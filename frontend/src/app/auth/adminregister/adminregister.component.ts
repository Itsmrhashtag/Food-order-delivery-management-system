import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent {
  email = '';
  password = '';
  confirmPassword = '';

  constructor(private authService: AuthService, private router: Router) {}

  register() {
    if (this.password != this.confirmPassword) {
      alert("Passwords does not match");
    }
    this.authService.registerAdmin(this.email, this.password).subscribe({
      next: (response) => {
        alert("Registration successful!");
        console.log(response);
        this.router.navigate(['/login']);
      },
      error: (error) => {
        alert("Registration failed!");
        console.error(error);
      }
    });
  }
}
