import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  constructor(private articleService: ArticleService) { }

  articles;

  ngOnInit() {
    this.articleService.getList().subscribe(
      data =>{
        if (data['code'] == 0){
          this.articles = data['data'];
        }
      }
    );
  }

}
