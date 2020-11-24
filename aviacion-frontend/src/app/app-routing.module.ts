import { Not403Component } from './pages/not403/not403.component';
import { Not404Component } from './pages/not404/not404.component';
import { GuardService } from './_service/guard.service';
import { LoginComponent } from './pages/login/login.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { ItinerarioComponent } from './pages/itinerario/itinerario.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'inicio', component: InicioComponent, canActivate : [GuardService]},
  { path: 'itinerarios', component: ItinerarioComponent, canActivate : [GuardService]},
  { path: 'login', component: LoginComponent},
  { path: 'not-404', component: Not404Component},
  { path: 'not-403', component: Not403Component},
  { path : '', redirectTo: 'login', pathMatch: 'full' },
  { path : '**', redirectTo: 'not-404', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
