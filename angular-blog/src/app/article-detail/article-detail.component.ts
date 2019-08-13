import {
  Component,
  OnInit,
  Renderer2,
  ViewChild,
  ElementRef
} from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { ArticleService } from "../services/article.service";

@Component({
  selector: "app-article-detail",
  templateUrl: "./article-detail.component.html",
  styleUrls: ["./article-detail.component.css"]
})
export class ArticleDetailComponent implements OnInit {
  constructor(
    private articleService: ArticleService,
    private router: Router,
    private route: ActivatedRoute,
    private renderer: Renderer2
  ) {}

  ngOnInit() {
    this.getArticle();
  }

  @ViewChild("content", { static: false })
  content: ElementRef;

  article;

  getArticle(): void {
    const id = +this.route.snapshot.paramMap.get("id");
    this.articleService.getArticleById(id).subscribe(data => {
      if (data["code"] == 0) {
        this.article = data["data"][0];
        console.log(this.article["articleContent"]);
      }else{
        alert("文章不存在");
        this.router.navigateByUrl("/articleList");
      }
    });
  }
}
