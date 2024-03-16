import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.email, this.password).subscribe({
      
      next: () => {
        if(localStorage.getItem('authority')=='USER'){this.router.navigate(['']);}
        if(localStorage.getItem('authority')=='ADMIN'){this.router.navigate(['']);}
        // this.router.navigate(['']);
      },
      error: (error) => {
        alert("Login failed!");
        console.error(error);
      }
    });
  }
}
