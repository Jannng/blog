import { Injectable, ViewChild, ElementRef, Input } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";

@Injectable()
export class LoginService {
  constructor(
    private http: HttpClient,
    private router: Router
  ) {
    
  }

  login(userAccount: string, userPassword: string) {
    this.http
      .post("http://localhost:8080/user/login", {
        userAccount: userAccount,
        userPassword: userPassword
      })
      .subscribe(
        data => {
          let code: number = data["code"];
          if (code == 0) {
            this.router.navigateByUrl("/articleList");
          } else {
            alert(data["msg"]);
            this.router.navigateByUrl("/login");
          }
        },
        error => {
          alert("用户名或密码错误");
          this.router.navigateByUrl("/login");
        }
      );
  }
}
