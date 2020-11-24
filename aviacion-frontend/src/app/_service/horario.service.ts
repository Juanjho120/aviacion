import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { GenericService } from './generic.service';
import { Horario } from './../_model/horario';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HorarioService extends GenericService<Horario> {

  constructor(protected http : HttpClient) {
    super(http, `${environment.HOST}/horarios`);
   }
}
