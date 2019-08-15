import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';

@Injectable()
export class CommentService{
    constructor(private http: HttpClient){}

    getList(articleId: number){
        return this.http.get("http://localhost:8080/comment/list/"+articleId);
    }

    publish(articleId: number, commentContent: string){
        return this.http.post("http://localhost:8080/comment/publish",{
            articleId: articleId,
            commentContent: commentContent
        },{withCredentials: true})
    }
}