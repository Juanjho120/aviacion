import { LoginService } from './login.service';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot } from '@angular/router';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate {

  constructor(
    private router : Router,
    private loginService : LoginService
  ) { }

  canActivate(route : ActivatedRouteSnapshot, state : RouterStateSnapshot) {
    let estaLogueado = this.loginService.estaLogueado();
    if(!estaLogueado) {
      this.loginService.cerrarSesion();
      return false;
    } else {
      //this.router.navigate(['inicio']);
      return true;
    }
  }
}
