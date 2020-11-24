import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { GenericService } from './generic.service';
import { Operador } from './../_model/operador';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OperadorService extends GenericService<Operador> {

  constructor(protected http : HttpClient) { 
    super(http, `${environment.HOST}/operadores`);
  }
}
