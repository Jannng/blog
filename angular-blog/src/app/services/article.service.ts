import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ArticleService {
  constructor(private http: HttpClient) {}

  getList() {
    return this.http.get("http://localhost:8080/article/getList");
  }

  getArticleById(id: number){
    return this.http.get("http://localhost:8080/article/get/"+id);
  }
}
