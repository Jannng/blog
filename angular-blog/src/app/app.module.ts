import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import { LoginComponent } from "./login/login.component";
import { RouterModule, Routes } from "@angular/router";
import { RegisterComponent } from "./register/register.component";
import { ArticleListComponent } from "./article-list/article-list.component";
import { PageNotFoundComponent } from "./page-not-found/page-not-found.component";
import { LoginService } from "./services/login.service";
import { ArticleService } from "./services/article.service";
import { ArticleDetailComponent } from "./article-detail/article-detail.component";
import { WriteArticleComponent } from "./write-article/write-article.component";
import { CategoryService } from "./services/category.service";
import { CommentListComponent } from "./comment-list/comment-list.component";
import { CommentDetailComponent } from "./comment-detail/comment-detail.component";
import { CommentService } from "./services/comment.service";
import { MyArticlesComponent } from "./my-articles/my-articles.component";
import { UpdateArticleComponent } from "./update-article/update-article.component";

const appRoutes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "articleList", component: ArticleListComponent },
  { path: "detail/:id", component: ArticleDetailComponent },
  { path: "write", component: WriteArticleComponent },
  { path: "myArticles", component: MyArticlesComponent },
  { path: "update/:id", component: UpdateArticleComponent },
  { path: "", redirectTo: "login", pathMatch: "full" }
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
    WriteArticleComponent,
    CommentListComponent,
    CommentDetailComponent,
    MyArticlesComponent,
    UpdateArticleComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes, { enableTracing: false }),
    HttpClientModule,
    FormsModule
  ],
  providers: [
    LoginService,
    ArticleService,
    Location,
    CategoryService,
    CommentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
