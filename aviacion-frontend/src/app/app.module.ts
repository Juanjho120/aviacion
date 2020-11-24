import { ServerErrorsInterceptor } from './../shared/server-errors.interceptor';
import { MaterialModule } from './material/material.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ItinerarioComponent } from './pages/itinerario/itinerario.component';
import { VueloIngresoComponent } from './pages/itinerario/vuelo-ingreso/vuelo-ingreso.component';
import { GanttComponent } from './pages/itinerario/gantt/gantt.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './pages/login/login.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { Not404Component } from './pages/not404/not404.component';
import { Not403Component } from './pages/not403/not403.component';

@NgModule({
  declarations: [
    AppComponent,
    ItinerarioComponent,
    VueloIngresoComponent,
    GanttComponent,
    InicioComponent,
    LoginComponent,
    Not404Component,
    Not403Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule
  ],
  providers: [
    {
      provide : HTTP_INTERCEPTORS,
      useClass : ServerErrorsInterceptor,
      multi : true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
