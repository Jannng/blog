import { Component, OnInit, Input } from '@angular/core';
import { CommentService } from '../services/comment.service';

@Component({
  selector: 'app-comment-list',
  templateUrl: './comment-list.component.html',
  styleUrls: ['./comment-list.component.css']
})
export class CommentListComponent implements OnInit {

  constructor(private commentService: CommentService) { }

  @Input() id: number;

  @Input() comments;

  ngOnInit() {
    this.commentService.getList(this.id).subscribe(
      data => {
        if (data["code"] == 0){
          this.comments = data["data"];
        }
      }
    );
  }


}
