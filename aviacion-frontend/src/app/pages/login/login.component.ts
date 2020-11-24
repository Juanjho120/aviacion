import { LoginService } from './../../_service/login.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin : FormGroup;

  constructor(
    private router : Router,
    private loginService : LoginService
  ) { }

  ngOnInit(): void {
    this.formLogin = new FormGroup({
      'username' : new FormControl('', Validators.required),
      'password' : new FormControl('', Validators.required)
    });
  }

  login() {
    let username = this.formLogin.value['username'];
    let password = this.formLogin.value['password'];
    if(this.loginService.login(username, password)) {
      sessionStorage.setItem('token', 'jtzun');
      this.router.navigate(['inicio']);
    }
  }

}
