import { Component } from '@angular/core';
import { LoginService } from './services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private loginService: LoginService,private router: Router){}

  logout(){
    this.loginService.logout().subscribe(
      data => {
        if (data['code'] == 0){
          this.router.navigateByUrl("/login");
        }
      }
    );
  }
}
