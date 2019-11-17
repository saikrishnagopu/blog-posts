package com.blog.controllers;

import com.blog.Utils.ConstantUtils;
import com.blog.beans.BlogPost;
import com.blog.beans.ServiceResponse;
import com.blog.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class BlogPostController extends BaseController{

    @Autowired
    private BlogPostService blogPostService;

    @RequestMapping(value = "/blogs", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ServiceResponse> getAllBlogs(@RequestHeader
                                                               HttpHeaders headers, @RequestParam(value = "limit", required = false) Integer limit,  @RequestParam(value = "offset", required = false) Integer offset) throws Throwable {
        ServiceResponse serviceResponse = new ServiceResponse();
        List<BlogPost> blogs;
        if (limit == null) {
            blogs = blogPostService.getAllBlogPosts();
        } else {
            blogs = blogPostService.getBlogPosts(offset != null ? offset : 0, limit);
        }
        serviceResponse.setStatusCode(ConstantUtils.SUCCESS);
        serviceResponse.setStatusMessage(ConstantUtils.FETECHED_BLOG_SUCCESS);
        serviceResponse.setPayload(blogs);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<ServiceResponse> getBlogById(@PathVariable(value = "id") String id, @RequestHeader
            HttpHeaders headers) throws Throwable {
        ServiceResponse serviceResponse = new ServiceResponse();
        BlogPost blog = blogPostService.getBlogPostById(Long.valueOf(id));
        if(blog == null){
            serviceResponse.setStatusCode(ConstantUtils.FAILED);
            serviceResponse.setStatusMessage(ConstantUtils.NOT_FOUND);
            return new ResponseEntity<ServiceResponse>(serviceResponse, HttpStatus.NOT_FOUND);
        }
        serviceResponse.setStatusCode(ConstantUtils.SUCCESS);
        serviceResponse.setStatusMessage(ConstantUtils.FETECHED_BLOG_SUCCESS);
        serviceResponse.setPayload(blog);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/blogs", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<ServiceResponse> createBlogPost(@RequestBody BlogPost blogPost, @RequestHeader HttpHeaders
            headers) throws Throwable {
        ServiceResponse serviceResponse = new ServiceResponse();
        if(!isValidUser(headers)){
            serviceResponse.setStatusCode(ConstantUtils.FAILED);
            serviceResponse.setStatusMessage(ConstantUtils.UN_AUTHENTICATED);
            return new ResponseEntity<>(serviceResponse, HttpStatus.UNAUTHORIZED);
        }
        BlogPost blog = blogPostService.saveBlogPost(blogPost);
        if(blog == null){
            serviceResponse.setStatusCode(ConstantUtils.FAILED);
            return new ResponseEntity<>(serviceResponse, HttpStatus.BAD_REQUEST);
        }
        serviceResponse.setStatusCode(ConstantUtils.SUCCESS);
        serviceResponse.setStatusMessage(ConstantUtils.CREATED_BLOG_SUCCESS);
        serviceResponse.setPayload(blog);
        return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<ServiceResponse> updateBlog(@RequestHeader HttpHeaders headers, @PathVariable(value = "id")
            String id, @RequestBody
                                                             BlogPost blogPost) throws Throwable {
        ServiceResponse serviceResponse = new ServiceResponse();
        if(!isValidUser(headers)){
            serviceResponse.setStatusCode(ConstantUtils.FAILED);
            serviceResponse.setStatusMessage(ConstantUtils.UN_AUTHENTICATED);
            return new ResponseEntity<>(serviceResponse, HttpStatus.UNAUTHORIZED);
        }
        BlogPost blog = blogPostService.updateBlogPost(blogPost, Long.valueOf(id));
        if(blog == null){
            return new ResponseEntity<>(serviceResponse, HttpStatus.BAD_REQUEST);
        }
        serviceResponse.setStatusCode(ConstantUtils.SUCCESS);
        serviceResponse.setStatusMessage(ConstantUtils.UPDATED_BLOG_SUCCESS);
        serviceResponse.setPayload(blog);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<ServiceResponse> deleteBlog(@RequestHeader HttpHeaders headers, @PathVariable(value="id")
            String
            id) throws Throwable {
        ServiceResponse serviceResponse = new ServiceResponse();
        if(!isValidUser(headers)){
            serviceResponse.setStatusCode(ConstantUtils.FAILED);
            serviceResponse.setStatusMessage(ConstantUtils.UN_AUTHENTICATED);
            return new ResponseEntity<>(serviceResponse, HttpStatus.UNAUTHORIZED);
        }
        BlogPost blogPost = blogPostService.deleteBlogPostById(Long.valueOf(id));
        if(blogPost == null){
            serviceResponse.setStatusMessage(ConstantUtils.NOT_FOUND);
            serviceResponse.setStatusCode(ConstantUtils.FAILED);
            return new ResponseEntity<>(serviceResponse, HttpStatus.NOT_FOUND);
        }
        serviceResponse.setStatusCode(ConstantUtils.SUCCESS);
        serviceResponse.setStatusMessage(ConstantUtils.DELETED_BLOG_SUCCESS);
        serviceResponse.setPayload(blogPost);
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}