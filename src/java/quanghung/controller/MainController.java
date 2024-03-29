package quanghung.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duong
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutServlet";
    private static final String GET_LIST = "GetList";
    private static final String GET_LIST_CONTROLLER = "GetListController";
    private static final String INPUT_DEVICE_INFORMATION = "InputDeviceInfo";
    private static final String INPUT_DEVICE_INFORMATION_CONTROLLER = "InputDeviceInfoController";
    private static final String CREATE_DEVICE = "CreateDevice";
    private static final String CREATE_DEVICE_CONTROLLER = "CreateDeviceController";
    private static final String SEARCH_DEVICE = "SearchDevice";
    private static final String SEARCH_DEVICE_CONTROLLER = "SearchDeviceController";
    private static final String DELETE_DEVICE = "DeleteDevice";
    private static final String DELETE_DEVICE_CONTROLLER = "DeleteDeviceController";
    private static final String UPDATE_DEVICE = "UpdateDevice";
    private static final String UPDATE_DEVICE_CONTROLLER = "UpdateDeviceController";
    private static final String UPDATE_PROFILE = "UpdateProfile";
    private static final String UPDATE_PROFILE_CONTROLLER = "UpdateProfileServlet";
    private static final String UPDATE_DEVICE_DETAIL = "UpdateDeviceDetail";
    private static final String UPDATE_DEVICE_DETAIL_CONTROLLER = "UpdateDeviceDetailController";
    private static final String FIND_PRODUCT = "FindProduct";
    private static final String FIND_PRODUCT_CONTROLLER = "FindProductController";
    private static final String VIEW_ALL_REQUEST_MANAGER = "LoadAllRequestManager";
    private static final String VIEW_ALL_REQUEST_MANAGER_CONTROLLER = "LoadAllRequestManagement";
    private static final String VIEW_PROCESSING_REQUEST_MANAGER = "LoadProcessingRequest";
    private static final String VIEW_APPROVE_REQUEST_MANAGER = "LoadApprovedRequest";
    private static final String VIEW_SUCCESSFUL_REQUEST_MANAGER = "LoadSuccessRequest";
    private static final String VIEW_RETURNED_REQUEST_MANAGER = "LoadReturnedRequest";
    private static final String VIEW_CANCEL_REQUEST_MANAGER = "LoadCanceledRequest";
    private static final String CREATE_WAREHOUSE = "createWarehouse";
    private static final String CREATE_WAREHOUSE_CONTROLLER = "CreateWarehouseController";
    private static final String GET_LIST_WAREHOUSE = "GetListWarehouse";
    private static final String GET_LIST_WAREHOUSE_CONTROLLER = "GetListWarehouseController";
    private static final String DELETE_WAREHOUSE = "DeleteWarehouse";
    private static final String DELETE_WAREHOUSE_CONTROLLER = "DeleteWarehouseController";
    private static final String UPDATE_WAREHOUSE = "UpdateWarehouse";
    private static final String UPDATE_WAREHOUSE_CONTROLLER = "UpdateWarehouseController";
    private static final String SEARCH_WAREHOUSE = "SearchWarehouse";
    private static final String SEARCH_WAREHOUSE_CONTROLLER = "SearchWarehouseController";
    private static final String CREATE_CATEGORY = "CreateCategory";
    private static final String CREATE_CATEGORY_CONTROLLER = "CreateCategoryController";
    private static final String GET_LIST_CATEGORY = "GetListCategory";
    private static final String GET_LIST_CATEGORY_CONTROLLER = "GetListCategoryController";
    private static final String DELETE_CATEGORY = "DeleteCategory";
    private static final String DELETE_CATEGORY_CONTROLLER = "DeleteCategoryController";
    private static final String UPDATE_CATEGORY = "UpdateCategory";
    private static final String UPDATE_CATEGORY_CONTROLLER = "UpdateCategoryController";
    private static final String SEARCH_CATEGORY = "SearchCategory";
    private static final String SEARCH_CATEGORY_CONTROLLER = "SearchCategoryController";
    private static final String CREATE_DESCRIPTION = "CreateDescription";
    private static final String CREATE_DESCRIPTION_CONTROLLER = "CreateDescriptionController";
    private static final String GET_LIST_DESCRIPTION = "GetListDescription";
    private static final String GET_LIST_DESCRIPTION_CONTROLLER = "GetListDescriptionController";
    private static final String DELETE_DESCRIPTION = "DeleteDescription";
    private static final String DELETE_DESCRIPTION_CONTROLLER = "DeleteDescriptionController";
    private static final String CREATE_DETAIL = "CreateDetail";
    private static final String CREATE_DETAIL_CONTROLLER = "CreateDetailController";
    private static final String UPDATE_DETAIL = "UpdateDetail";
    private static final String UPDATE_DETAIL_CONTROLLER = "UpdateDetailController";
    private static final String DELETE_DETAIL = "DeleteDetail";
    private static final String DELETE_DETAIL_CONTROLLER = "DeleteDetailController";
    private static final String UPDATE_STATUS_ACCOUNT = "UpdateAccountStatus";
    private static final String UPDATE_STATUS_ACCOUNT_CONTROLLER = "UpdateAccountStatusServlet";
    private static final String SEARCH_ACCOUNT = "SearchByID";
    private static final String SEARCH_ACCOUNT_CONTROLLER = "SearchByIDServlet";
    private static final String HOME_SEARCH_DEVICE = "HomeSearchDevice";
    private static final String HOME_SEARCH_DEVICE_CONTROLLER = "HomeSearchDeviceController";
    private static final String DEVICE_DETAIL = "Detail";
    private static final String DEVICE_DETAIL_CONTROLLER = "DetailController";
    private static final String UPDATE_IMG = "UpdateImg";
    private static final String UPDATE_IMG_CONTROLLER = "UpdateImgController";
    private static final String OPEN_UPDATE_IMG_PAGE = "OpenUpdateImgPage";
    private static final String OPEN_UPDATE_IMG_PAGE_CONTROLLER = "OpenUpdateImgPageController";
    private static final String FILTER_DEVICE = "FilterDevice";
    private static final String FILTER_DEVICE_CONTROLLER = "FilterDeviceController";
    private static final String UPDATE_DEVICE_CATEGORY = "UpdateDeviceCategory";
    private static final String UPDATE_DEVICE_CATEGORY_CONTROLLER = "UpdateDeviceCategoryController";
    private static final String UPDATE_CATEGORY_DEVICE_INFO = "UpdateCategoryDeviceInfo";
    private static final String UPDATE_CATEGORY_DEVICE_INFO_CONTROLLER = "InputCategoryDeviceInfoController";
    private static final String UPDATE_DEVICE_DETAIL_CATEGORY = "UpdateDeviceDetailCategory";
    private static final String UPDATE_DEVICE_DETAIL_CATEGORY_CONTROLLER = "UpdateDeviceDetailCategoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");

            if (CREATE_DEVICE.equals(action)) {
                url = CREATE_DEVICE_CONTROLLER;
            } else if (SEARCH_DEVICE.equals(action)) {
                url = SEARCH_DEVICE_CONTROLLER;
            } else if (DELETE_DEVICE.equals(action)) {
                url = DELETE_DEVICE_CONTROLLER;
            } else if (UPDATE_DEVICE.equals(action)) {
                url = UPDATE_DEVICE_CONTROLLER;
            } else if (FIND_PRODUCT.equals(action)) {
                url = FIND_PRODUCT_CONTROLLER;
            } else if (GET_LIST.equals(action)) {
                url = GET_LIST_CONTROLLER;
            } else if (INPUT_DEVICE_INFORMATION.equals(action)) {
                url = INPUT_DEVICE_INFORMATION_CONTROLLER;
            } else if (UPDATE_DEVICE_DETAIL.equals(action)) {
                url = UPDATE_DEVICE_DETAIL_CONTROLLER;
            } else if (action.equals(VIEW_ALL_REQUEST_MANAGER)) {
                url = VIEW_ALL_REQUEST_MANAGER_CONTROLLER;
            } else if (action.equals(VIEW_PROCESSING_REQUEST_MANAGER)) {
                url = VIEW_ALL_REQUEST_MANAGER_CONTROLLER;
            } else if (action.equals(VIEW_APPROVE_REQUEST_MANAGER)) {
                url = VIEW_ALL_REQUEST_MANAGER_CONTROLLER;
            } else if (action.equals(VIEW_SUCCESSFUL_REQUEST_MANAGER)) {
                url = VIEW_ALL_REQUEST_MANAGER_CONTROLLER;
            } else if (action.equals(VIEW_RETURNED_REQUEST_MANAGER)) {
                url = VIEW_ALL_REQUEST_MANAGER_CONTROLLER;
            } else if (action.equals(VIEW_CANCEL_REQUEST_MANAGER)) {
                url = VIEW_ALL_REQUEST_MANAGER_CONTROLLER;
            } else if (UPDATE_PROFILE.equals(action)) {
                url = UPDATE_PROFILE_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (CREATE_WAREHOUSE.equals(action)) {
                url = CREATE_WAREHOUSE_CONTROLLER;
            } else if (DELETE_WAREHOUSE.equals(action)) {
                url = DELETE_WAREHOUSE_CONTROLLER;
            } else if (UPDATE_WAREHOUSE.equals(action)) {
                url = UPDATE_WAREHOUSE_CONTROLLER;
            } else if (SEARCH_WAREHOUSE.equals(action)) {
                url = SEARCH_WAREHOUSE_CONTROLLER;
            } else if (GET_LIST_CATEGORY.equals(action)) {
                url = GET_LIST_CATEGORY_CONTROLLER;
            } else if (CREATE_CATEGORY.equals(action)) {
                url = CREATE_CATEGORY_CONTROLLER;
            } else if (UPDATE_CATEGORY.equals(action)) {
                url = UPDATE_CATEGORY_CONTROLLER;
            } else if (DELETE_CATEGORY.equals(action)) {
                url = DELETE_CATEGORY_CONTROLLER;
            } else if (GET_LIST_WAREHOUSE.equals(action)) {
                url = GET_LIST_WAREHOUSE_CONTROLLER;
            } else if (GET_LIST_DESCRIPTION.equals(action)) {
                url = GET_LIST_DESCRIPTION_CONTROLLER;
            } else if (CREATE_DESCRIPTION.equals(action)) {
                url = CREATE_DESCRIPTION_CONTROLLER;
            } else if (CREATE_DETAIL.equals(action)) {
                url = CREATE_DETAIL_CONTROLLER;
            } else if (UPDATE_DETAIL.equals(action)) {
                url = UPDATE_DETAIL_CONTROLLER;
            } else if (DELETE_DETAIL.equals(action)) {
                url = DELETE_DETAIL_CONTROLLER;
            } else if (DELETE_DESCRIPTION.endsWith(action)) {
                url = DELETE_DESCRIPTION_CONTROLLER;
            } else if (SEARCH_CATEGORY.equals(action)) {
                url = SEARCH_CATEGORY_CONTROLLER;
            } else if (SEARCH_ACCOUNT.equals(action)) {
                url = SEARCH_ACCOUNT_CONTROLLER;
            } else if (UPDATE_STATUS_ACCOUNT.equals(action)) {
                url = UPDATE_STATUS_ACCOUNT_CONTROLLER;
            } else if (HOME_SEARCH_DEVICE.equals(action)) {
                url = HOME_SEARCH_DEVICE_CONTROLLER;
            } else if (DEVICE_DETAIL.equals(action)) {
                url = DEVICE_DETAIL_CONTROLLER;
            } else if (UPDATE_IMG.equals(action)) {
                url = UPDATE_IMG_CONTROLLER;
            } else if (OPEN_UPDATE_IMG_PAGE.equals(action)) {
                url = OPEN_UPDATE_IMG_PAGE_CONTROLLER;
            } else if (FILTER_DEVICE.equals(action)) {
                url = FILTER_DEVICE_CONTROLLER;
            } else if (UPDATE_DEVICE_CATEGORY.equals(action)) {
                url = UPDATE_DEVICE_CATEGORY_CONTROLLER;
            } else if (UPDATE_CATEGORY_DEVICE_INFO.equals(action)) {
                url = UPDATE_CATEGORY_DEVICE_INFO_CONTROLLER;
            } else if (UPDATE_DEVICE_DETAIL_CATEGORY.equals(action)) {
                url = UPDATE_DEVICE_DETAIL_CATEGORY_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
