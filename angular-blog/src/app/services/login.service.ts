import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class LoginService {
  constructor(private http: HttpClient) {}

  login(userAccount: string, userPassword: string) {
    this.http
      .post("http://localhost:8080/user/login", {
        userAccount: userAccount,
        userPassword: userPassword
      })
      .subscribe(
        data => {
          console.log("Post success", data);
        },
        error => {
          console.log("Error", error);
        }
      );
  }
}
