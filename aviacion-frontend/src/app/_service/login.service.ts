import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(
    private router : Router
  ) { }

  login(username : string, password : string) {
    if(username == 'jtzun' && password == 'jtzun') {
      return true;
    }
    this.router.navigate(['not-403']);
    return false;
  }

  estaLogueado() {
    if(sessionStorage.getItem('token')!=null) {
      return true;
    }
    return false;
  }

  cerrarSesion() {
    sessionStorage.clear();
    this.router.navigate(['login']);
  }

}
