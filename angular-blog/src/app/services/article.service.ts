import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ArticleService {
  constructor(private http: HttpClient) {}

  getList() {
    return this.http.get("http://localhost:8080/article/getList");
  }

  getArticleById(id: number) {
    return this.http.get("http://localhost:8080/article/get/" + id);
  }

  publishArticle(title: string, content: string, category: number) {
    return this.http.post("http://localhost:8080/article/publish", {
      articleTitle: title,
      articleContent: content,
      categoryId: category
    },{withCredentials:true});
  }

  view(id: number){
    return this.http.get("http://localhost:8080/article/view/"+id);
  }
}
