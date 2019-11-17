Admin users can post, update and delete blogs. (Authenticated endpoints)
Posting a blog - POST /v1/blogs
Required fields - name, content
Unauthenticated requests should throw a 401.
Requests with missing required fields should return 400.
Requests with non-string values for name and content should return 400.
Success response should be valid JSON and have an integer id field for the created blog.

Updating a blog - PUT /v1/blogs/{{blogId}}
Unauthenticated requests should throw a 401.
Invalid requests should throw a 400.
Deleting a blog - DELET /v1/blogs/{{blogId}}
Unauthenticated requests should throw a 401.
Deleting an already deleted record should return a 200.
Non-admin users can fetch a listing of all blogs(names and posted date) and get an individual blog item to see it in detail (name, posted date and content)
Get blog listing - GET /v1/blogs

Get listing should accept a limit param to limit the number of returned records.
GET /v1/blogs?limit=3
Get single blog item - GET /v1/blogs/{{blogId}}

Trying to get a deleted/non existent blog should return 404.
