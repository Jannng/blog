import { Component, OnInit } from "@angular/core";
import { ActionSequence } from "protractor";
import { ActivatedRoute, Router } from "@angular/router";
import { ArticleService } from "../services/article.service";

@Component({
  selector: "app-update-article",
  templateUrl: "./update-article.component.html",
  styleUrls: ["./update-article.component.css"]
})
export class UpdateArticleComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private articleService: ArticleService,
    private router: Router
  ) {}

  
  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get("id");
    this.getArticle();
  }
  title: string;
  content: string;
  id: number;
  article;

  getArticle() {
    this.articleService.getArticleById(this.id).subscribe(data => {
      if (data["code"] == 0) {
        this.article = data["data"][0];
        this.title = this.article["articleTitle"];
        this.content = this.article["articleContent"];
      }
    });
  }

  update(){
    this.articleService.update(this.id, this.title, this.content).subscribe(
      data => {
        if (data['code'] == 0){
          alert("更新成功!")
          this.router.navigateByUrl("/detail/"+this.id);
        }else{
          alert("没有权限")
          this.router.navigateByUrl("/myArticle");
        }
      }
    );
  }
}
