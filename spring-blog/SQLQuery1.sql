use Intern_test;

CREATE TABLE jt1n.[blog_user](
	user_id bigint identity(1,1) primary key not null,
 	user_account varchar(10) not null,
	user_password varchar(20) not null,
	user_type varchar(10) default 'user'
)

CREATE TABLE jt1n.[blog_articles](
	article_id bigint identity(1,1) primary key not null,
	user_id bigint not null,
	article_title ntext not null,
	article_content ntext not null,
	article_views bigint not null,
	category_id bigint not null,
	article_comment_count bigint not null,
	article_date datetime default getdate()
)

CREATE TABLE jt1n.[blog_comments](
	comment_id bigint identity(1,1) primary key not null,
	user_id bigint not null,
	article_id bigint not null,
	comment_content text not null,
	comment_date datetime default getdate(),
	parent_comment_id bigint not null
)

CREATE TABLE jt1n.[blog_category](
	category_id bigint identity(1,1) primary key not null,
	category_name nvarchar(10) not null,
	category_date datetime default getdate()
)
select * from jt1n.blog_user;

insert into jt1n.blog_articles 
(user_id, article_title, article_content, article_views, category_id, article_comment_count)
values(1, N'blog', N'', 0, 1, 0)

select article_id, article_title, article_content, article_comment_count, article_views,article_date,c.category_name,user_account
from jt1n.blog_articles a left join jt1n.blog_category c on a.category_id = c.category_id
left join jt1n.blog_user u on a.user_id = u.user_id

delete from jt1n.blog_articles where article_id = 2

insert into jt1n.blog_category (category_name) values(N'')
insert into jt1n.blog_category (category_name) values('Java')   
insert into jt1n.blog_category (category_name) values('Spring')   
insert into jt1n.blog_category (category_name) values('angular')      

select category_id, category_name, category_date 
from jt1n.blog_category

insert into jt1n.blog_user (user_account,user_password) values('tang','123');
select * from jt1n.blog_user
