import {
  Component,
  OnInit,
  ViewChild,
  ElementRef,
  Input,
  Renderer,
  Renderer2
} from "@angular/core";
import { LoginService } from "../services/login.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  constructor(
    private loginService: LoginService,
  ) {}

  ngOnInit() {}


  userAccount: string;
  userPassword: string;

  login() {
    this.loginService.login(this.userAccount, this.userPassword);
  }
}
