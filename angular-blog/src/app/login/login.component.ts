import { Component, OnInit, Output, EventEmitter } from "@angular/core";
import { LoginService } from "../services/login.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {}

  userAccount: string;
  userPassword: string;
  registerAccount: string;
  registerPassword: string;

  login() {
    this.loginService
      .login(this.userAccount, this.userPassword)
      .subscribe(data => {
        let code: number = data["code"];
        if (code == 0) {
          this.router.navigateByUrl("/articleList");
        } else {
          alert(data["msg"]);
          this.router.navigateByUrl("/login");
        }
      });
  }

  register() {
    this.loginService
      .register(this.registerAccount, this.registerPassword)
      .subscribe(data => {
        if (data["code"] == 0) {
          alert("注册成功");
          this.registerAccount = "";
          this.registerPassword = "";
        }
      });
  }
}
