/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conant.order.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.conant.order.common.PageMsg;
import com.conant.order.dao.LensModelDao;
import com.conant.order.dao.OrderDao;
import com.conant.order.util.Logger;
import com.conant.order.util.ProcessException;
import com.conant.order.vo.LensModel;
import com.conant.order.vo.OrsOrder;
import com.conant.order.web.form.LensModelEditor;
import com.conant.order.web.form.LensOrderForm;

/**
 * 
 * @author Administrator
 */
public class AddLensOrderController extends SimpleFormController
{
	private static final Logger log = Logger.getLogger(
			"AddOrderFormController", Logger.DEBUG, true);
	private OrderDao orderDao;
	private LensModelDao lensModelDao;
	private List lensmodels;

	public AddLensOrderController()
	{
		// Initialize controller properties here or
		// in the Web Application Context
	}

	public OrderDao getOrderDao()
	{
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao)
	{
		this.orderDao = orderDao;
	}

	public LensModelDao getLensModelDao()
	{
		return lensModelDao;
	}

	public void setLensModelDao(LensModelDao lensModelDao)
	{
		this.lensModelDao = lensModelDao;
	}

	protected Object formBackingObject(HttpServletRequest request)
			throws ModelAndViewDefiningException
	{
			return new LensOrderForm();
	}

	protected Map referenceData(HttpServletRequest request) throws Exception
	{
		Map model = new HashMap();
		lensmodels = lensModelDao.getLensModel();
		model.put("lensmodels", lensmodels);
		return model;
	}

	// Use onSubmit instead of doSubmitAction
	// when you need access to the Request, Response, or BindException objects
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception
	{

		log.info("AddOrderFormController onSubmit...");
		LensOrderForm orderForm = (LensOrderForm) command;
		OrsOrder order = orderForm.getOrder();

		PageMsg pageMsg = new PageMsg();

		try
		{
			orderDao.insertOrder(order);
			pageMsg.setMsg("Add order successfully!");
			pageMsg.setUrl("/queryOrders.ord");
			return new ModelAndView(this.getSuccessView(), "success", pageMsg);
		}
		catch(ProcessException pe)
		{
			pageMsg.setMsg(pe.getErrorReason());
			pageMsg.setUrl("/addLensOrder.ord");
			return new ModelAndView("common/err", "error", pageMsg);
		}
		catch(Exception ex)
		{
			pageMsg.setMsg(ex.getMessage());
			return new ModelAndView("common/err", "error", pageMsg);
		}
	}

	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception
	{
		super.initBinder(request, binder);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		// CustomDateEditor should be set allowEmpty, otherwise it would throw
		// exception
		// before validator can handle invalid values.
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(LensModel.class, new LensModelEditor(
				lensmodels));
	}
}
