import { Component, OnInit } from "@angular/core";
import { CategoryService } from "../services/category.service";
import { ArticleService } from "../services/article.service";
import { Router } from '@angular/router';

@Component({
  selector: "app-write-article",
  templateUrl: "./write-article.component.html",
  styleUrls: ["./write-article.component.css"]
})
export class WriteArticleComponent implements OnInit {
  constructor(
    private categoryService: CategoryService,
    private articleService: ArticleService,
    private router: Router
  ) {}

  ngOnInit() {
    this.categoryService.getCategories().subscribe(data => {
      this.categories = data["data"];
      console.log(this.categories);
    });
  }
  

  categories;
  title: string;
  content: string;
  category: number;

  publish() {
    this.articleService.publishArticle(
      this.title,
      this.content,
      this.category
    ).subscribe(
      data => {
        if (data['code'] == 0){
          this.router.navigateByUrl("/articleList");
        }else{
          alert(data['msg']);
          this.router.navigateByUrl("/login");
        }
      }
    );
  }

  getChange(category: number) {
    this.category = category;
  }
}
