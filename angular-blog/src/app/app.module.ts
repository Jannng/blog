import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms'

import { AppComponent } from "./app.component";
import { LoginComponent } from "./login/login.component";
import { RouterModule, Routes } from "@angular/router";
import { RegisterComponent } from "./register/register.component";
import { ArticleListComponent } from "./article-list/article-list.component";
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LoginService } from './services/login.service';
import { ArticleService } from './services/article.service';
import { ArticleDetailComponent } from './article-detail/article-detail.component';
import { WriteArticleComponent } from './write-article/write-article.component';

const appRoutes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "articleList", component: ArticleListComponent},
  { path: "detail/:id", component: ArticleDetailComponent},
  { path: "write", component: WriteArticleComponent},
  { path: "", redirectTo: "login", pathMatch: "full" },
  // { path: "**", component: PageNotFoundComponent }
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ArticleListComponent,
    PageNotFoundComponent,
    ArticleDetailComponent,
    WriteArticleComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes, { enableTracing: false }),
    HttpClientModule,
    FormsModule
  ],
  providers: [LoginService, ArticleService,Location],
  bootstrap: [AppComponent]
})
export class AppModule {}
