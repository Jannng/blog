import { Component, OnInit } from "@angular/core";
import { ArticleService } from "../services/article.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-my-articles",
  templateUrl: "./my-articles.component.html",
  styleUrls: ["./my-articles.component.css"]
})
export class MyArticlesComponent implements OnInit {
  constructor(private articleService: ArticleService, private router: Router) {}

  articles;

  ngOnInit() {
    this.getMyArticles();
  }

  getMyArticles() {
    this.articleService.getArticlesByUser().subscribe(data => {
      let code = data["code"];
      if (code == 0) {
        this.articles = data["data"];
      } else if (code == -4) {
        alert(data["msg"]);
        this.router.navigateByUrl("/login");
      }
    });
  }

  delete(ids: string) {
    this.articleService.delete(ids).subscribe(data => {
      if (data['code'] == 0){
        alert("删除成功");
        this.getMyArticles();
      }
    });
  }
}
