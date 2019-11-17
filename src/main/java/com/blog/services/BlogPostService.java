package com.blog.services;

import com.blog.beans.BlogPost;

import java.util.List;

public interface BlogPostService {

    List<BlogPost> getAllBlogPosts();

    List<BlogPost> getBlogPosts(int offset, int limit);

    BlogPost getBlogPostById(Long id);

    BlogPost saveBlogPost(BlogPost blogPost);

    BlogPost updateBlogPost(BlogPost blogPost, Long id);

    BlogPost deleteBlogPostById(Long id);

}
