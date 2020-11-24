import { Vuelo } from './../../../_model/vuelo';
import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { VueloService } from './../../../_service/vuelo.service';
import { OperadorService } from './../../../_service/operador.service';
import { HorarioService } from './../../../_service/horario.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Operador } from 'src/app/_model/operador';
import { Horario } from 'src/app/_model/horario';
import * as moment from 'moment';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-vuelo-ingreso',
  templateUrl: './vuelo-ingreso.component.html',
  styleUrls: ['./vuelo-ingreso.component.css']
})
export class VueloIngresoComponent implements OnInit {

  form : FormGroup;

  idOperador : number = 0;
  operadores$ : Observable<Operador[]>;

  idHorarioSalida : number = 0;
  idHorarioEntrada : number = 0;
  horariosSalida$ : Observable<Horario[]>;
  horariosEntrada : Horario[] = [];

  lunes : boolean = false;
  martes : boolean = false;
  miercoles : boolean = false;
  jueves : boolean = false;
  viernes : boolean = false;
  sabado : boolean = false;
  domingo : boolean = false;

  minFecha : Date = new Date();
  fechaSeleccionada : Date = new Date();
  formatoFecha : string = "YYYY-MM-DD";
  fechaFormato : string = "";

  fechas : string[] = [];

  constructor(
    private horarioService : HorarioService,
    private operadorService : OperadorService,
    private vueloService : VueloService,
    private snackBar : MatSnackBar
  ) { }

  ngOnInit(): void {
    this.initForm();

    this.vueloService.getMensajeCambio().subscribe(data => {
      this.snackBar.open(data, 'AVISO', {duration : 2000});
    });

    this.operadores$ = this.operadorService.getAll();

    this.horariosSalida$ = this.horarioService.getAll();

    this.form.get('horarioEntrada').disable();

  }

  initForm() {
    this.form = new FormGroup({
      'operador' : new FormControl('', Validators.required),
      'numero' : new FormControl('', [Validators.minLength(5), Validators.maxLength(5)]),
      'horarioEntrada' : new FormControl('', Validators.required),
      'horarioSalida' : new FormControl('', Validators.required),
      'fechaIngreso' : new FormControl('', Validators.required)
    })
  }

  f() {
    return this.form.controls;
  }

  evaluarFechas() {
    this.fechas = [];
    if(this.lunes) {
      this.procesarFecha(1);
    }

    if(this.martes) {
      this.procesarFecha(2);
    }

    if(this.miercoles) {
      this.procesarFecha(3);
    }

    if(this.jueves) {
      this.procesarFecha(4);
    }

    if(this.viernes) {
      this.procesarFecha(5);
    }

    if(this.sabado) {
      this.procesarFecha(6);
    }

    if(this.domingo) {
      this.procesarFecha(7);
    }
  }

  procesarFecha(dayINeed : number) {
    let fechaMoment = moment(this.fechaSeleccionada);
    let dayFechaMoment = fechaMoment.isoWeekday();
    let dateTarget : Date;

    if(dayFechaMoment <= dayINeed) {
      dateTarget = fechaMoment.isoWeekday(dayINeed).toDate();
    } else {
      dateTarget = fechaMoment.add(1, 'week').isoWeekday(dayINeed).toDate(); 
    }
    this.fechas.push(moment(dateTarget).format(this.formatoFecha));
  }

  operar() {
    this.evaluarFechas();

    for(let fecha of this.fechas) {
      let vuelo = new Vuelo();
      vuelo.fechaIngreso = fecha;
      vuelo.numero = this.form.value['numero'];
      vuelo.operador = new Operador();
      vuelo.operador.idOperador = this.idOperador;
      vuelo.horarioEntrada = new Horario();
      vuelo.horarioSalida = new Horario();
      vuelo.horarioEntrada.idHorario = this.idHorarioEntrada;
      vuelo.horarioSalida.idHorario = this.idHorarioSalida;
      this.vueloService.create(vuelo).pipe(switchMap(() => {
        return this.vueloService.getAll();
      })).subscribe(data => {
        this.vueloService.setObjetoCambio(data);
        this.vueloService.setMensajeCambio('Vuelo itinerado');
      });
    }

    this.resetearFormulario();  
  }

  resetearFormulario() {
    this.lunes = false;
    this.martes = false;
    this.miercoles = false;
    this.jueves = false;
    this.viernes = false;
    this.sabado = false;
    this.domingo = false;
    this.form.reset();
    this.idHorarioEntrada = 0;
    this.idHorarioSalida = 0;
    this.form.get('horarioEntrada').disable();
    this.horariosEntrada = [];
    this.fechaSeleccionada = new Date();
    this.fechaFormato = "";
    this.idOperador = 0;
  }

  cambiarFecha(e : any) {
    this.fechaSeleccionada = e.value;
    this.fechaFormato = moment(this.fechaSeleccionada).format(this.formatoFecha);
  }

  filtrarHorariosEntrada() {
    this.form.get('horarioEntrada').enable();

    this.horarioService.getAll().subscribe(data => {
      this.horariosEntrada = data;
      this.horariosEntrada.splice(0, this.idHorarioSalida);
    });
  }

  evaluarBotonGuardar() {
    if(this.form.valid && (this.lunes || this.martes || this.miercoles || this.jueves || this.viernes || this.sabado || this.domingo)) {
      return false;
    }
    return true;
  }

}
