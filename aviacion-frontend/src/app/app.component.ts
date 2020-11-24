import { LoginService } from './_service/login.service';
import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(
    public loginService : LoginService
  ) { }

  title = 'aviacion-frontend';
  opened : boolean = true;
}
