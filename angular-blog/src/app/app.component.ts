import { Component } from "@angular/core";
import { LoginService } from "./services/login.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  constructor(private loginService: LoginService, private router: Router) {}

  loginUser;

  logout() {
    this.loginService.logout().subscribe(data => {
      if (data["code"] == 0) {
        this.loginUser = null;
        this.router.navigateByUrl("/login");
      }
    });
  }

  onActivate() {
    this.loginService.isLogin().subscribe(data => {
      if (data["code"] == 0) {
        console.log("1");
        this.loginUser = 'login';
      } else {
        console.log("2");
      }
    });
  }
}
