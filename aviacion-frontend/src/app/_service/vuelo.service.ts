import { HttpClient } from '@angular/common/http';
import { environment } from './../../environments/environment';
import { GenericService } from './generic.service';
import { Vuelo } from './../_model/vuelo';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VueloService extends GenericService<Vuelo> {

  constructor(protected http : HttpClient) {
    super(http, `${environment.HOST}/vuelos`);
  }

  getByFechaIngreso(fechaIngreso : string) {
    return this.http.get<Vuelo[]>(`${this.url}/fecha/${fechaIngreso}`);
  }
  
}
