import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { ArticleService } from "../services/article.service";
import { CommentService } from "../services/comment.service";
import { LoginService } from "../services/login.service";

@Component({
  selector: "app-article-detail",
  templateUrl: "./article-detail.component.html",
  styleUrls: ["./article-detail.component.css"]
})
export class ArticleDetailComponent implements OnInit {
  constructor(
    private articleService: ArticleService,
    private loginService: LoginService,
    private commentService: CommentService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get("id");
    this.view();
    this.getArticle();
  }

  id: number;

  commentContent: string;

  comments;

  article;

  getArticle(): void {
    this.articleService.getArticleById(this.id).subscribe(data => {
      if (data["code"] == 0) {
        this.article = data["data"][0];
      } else {
        alert("文章不存在");
        this.router.navigateByUrl("/articleList");
      }
    });
  }

  publish() {
    this.commentService
      .publish(this.id, this.commentContent)
      .subscribe(data => {
        if (data["code"] == 0) {
          this.commentService.getList(this.id).subscribe(result => {
            if (result["code"] == 0) {
              this.comments = result["data"];
            }
          });
        }
      });
  }

  isLogin() {
    this.loginService.isLogin().subscribe(data => {
      if (data["code"] == 0) {
      } else {
        alert(data["msg"]);
      }
    });
  }

  view() {
    this.articleService.view(this.id).subscribe(data => {
      if (data["code"] != 0) {
        alert(data["msg"]);
        this.router.navigateByUrl("/articleList");
      }
    });
  }
}
