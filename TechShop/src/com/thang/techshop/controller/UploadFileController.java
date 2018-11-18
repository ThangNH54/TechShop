package com.thang.techshop.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFileController
 */
@WebServlet("/UploadFileController")
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// upload settings
		private final String UPLOAD_DIRECTORY="images/avatar";
	    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
	    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String view=(String) session.getAttribute("view");
		String idFile=Integer.toString((int) (session.getAttribute("idFile")));	
		System.out.println(idFile);
		if(idFile==null) idFile="";
		// checks if the request actually contains upload file
		session.removeAttribute("view");
		session.removeAttribute("idFile");
		
		if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
			request.setAttribute("msg", "Không có file được tải lên");
			 request.setAttribute("checkUploadFile",false);
			getServletContext().getRequestDispatcher("view").forward(request, response);
        }
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
 
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
 
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")+  UPLOAD_DIRECTORY;
        
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) 
        {
            uploadDir.mkdir();
        }
 
        try {
        	
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            String fileName=idFile;
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                       fileName += new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
 
                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("checkUploadFile",true);
                        request.setAttribute("path",UPLOAD_DIRECTORY+"/" +fileName );
                    }
                }
            }

        } catch (Exception ex) {
            request.setAttribute("msg","Thất bại .Có lỗi xảy ra : " + ex.getMessage());
            request.setAttribute("checkUploadFile",false);
        }
		
        // redirects client to message page
        request.getRequestDispatcher(view).forward(request, response);
		
	}
	


}
