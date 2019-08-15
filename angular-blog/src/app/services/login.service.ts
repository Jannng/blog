import { Injectable} from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class LoginService {
  constructor(
    private http: HttpClient
  ) {
    
  }

  register(userAccount: string, userPassword: string){
    return this.http.post("http://localhost:8080/user/register",{
      userAccount: userAccount,
      userPassword: userPassword
    });
  }

  login(userAccount: string, userPassword: string) {
    return this.http
      .post("http://localhost:8080/user/login", {
        userAccount: userAccount,
        userPassword: userPassword
      },{withCredentials: true});
  }

  logout(){
    return this.http.get("http://localhost:8080/user/logout",{withCredentials: true});
  }

  isLogin(){
    return this.http.get("http://localhost:8080/user/isLogin",{withCredentials: true});
  }
}
