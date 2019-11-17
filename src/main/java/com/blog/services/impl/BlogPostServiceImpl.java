package com.blog.services.impl;

import com.blog.Utils.BlogPostBuilder;
import com.blog.beans.BlogPost;
import com.blog.models.Blog;
import com.blog.processor.BlogPostRepository;
import com.blog.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private BlogPostBuilder blogPostBuilder;

    @Override
    public List<BlogPost> getAllBlogPosts() {
        List<Blog> blogs = blogPostRepository.findAll();
        return blogPostBuilder.getBlogPostsFromBlogs(blogs);
    }

    @Override
    public List<BlogPost> getBlogPosts(int offset, int limit) {
        List<Blog> blogs = blogPostRepository.findBlogs(limit, offset);
        return blogPostBuilder.getBlogPostsFromBlogs(blogs);
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        Blog blog = blogPostRepository.findOne(id);
        if(blog == null){
            return null;
        }
        return blogPostBuilder.getBlogPostFromBlog(blog);
    }

    @Override
    public BlogPost saveBlogPost(BlogPost blogPost) {
        if(!isValidBlogPost(blogPost)){
            return null;
        }
        Blog blog = blogPostBuilder.createBlogFromBlogPost(blogPost);
        blog = blogPostRepository.save(blog);
        return blogPostBuilder.getBlogPostFromBlog(blog);
    }

    @Override
    public BlogPost updateBlogPost(BlogPost blogPost, Long id) {
        if(!isValidBlogPost(blogPost)){
            return null;
        }
        Blog oldBlog = blogPostRepository.findOne(id);
        Blog blog = blogPostBuilder.updateBlogFromBlogPost(blogPost, oldBlog);
        blog = blogPostRepository.save(blog);
        return blogPostBuilder.getBlogPostFromBlog(blog);
    }

    @Override
    public BlogPost deleteBlogPostById(Long id) {
        Blog oldBlog = blogPostRepository.findOne(id);
        if(oldBlog == null){
            return null;
        }
        oldBlog.setActive(Boolean.FALSE);
        Blog blog = blogPostRepository.save(oldBlog);
        return blogPostBuilder.getBlogPostFromBlog(blog);
    }

    private boolean isValidBlogPost(BlogPost blogPost){
        if(StringUtils.isEmpty(blogPost.getName()) || StringUtils.isEmpty(blogPost.getContent())){
            return false;
        }
        return true;
    }
}
