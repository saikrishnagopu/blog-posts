package com.blog.Utils;

import com.blog.beans.BlogPost;
import com.blog.models.Blog;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostBuilder {

    public BlogPost getBlogPostFromBlog(Blog blog) {
        BlogPost blogPost = new BlogPost();
        blogPost.setId(blog.getId());
        blogPost.setName(blog.getName());
        blogPost.setContent(blog.getContent());
        blogPost.setActive(blog.isActive());
        blogPost.setCreatedAt(blog.getCreatedOn() != null ? blog.getCreatedOn().getTime() : null);
        return blogPost;
    }

    public List<BlogPost> getBlogPostsFromBlogs(List<Blog> blogs) {
        List<BlogPost> blogPosts = new ArrayList<>();
        if (CollectionUtils.isEmpty(blogs)) {
            return blogPosts;
        }
        for (Blog blog : blogs) {
            BlogPost blogPost = getBlogPostFromBlog(blog);
            blogPosts.add(blogPost);
        }
        return blogPosts;
    }

    public Blog createBlogFromBlogPost(BlogPost blogPost) {
        Blog blog = new Blog();
        blog.setName(blogPost.getName());
        blog.setContent(blogPost.getContent());
        blog.setActive(Boolean.TRUE);
        return blog;
    }

    public Blog updateBlogFromBlogPost(BlogPost blogPost, Blog blog) {
        blog.setName(blogPost.getName());
        blog.setContent(blogPost.getContent());
        blog.setActive(Boolean.TRUE);
        return blog;
    }

}
