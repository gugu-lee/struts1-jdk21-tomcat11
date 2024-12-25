/*
 * $Id: MockServletContext.java 471754 2006-11-06 14:55:09Z husted $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts.mock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.FilterRegistration.Dynamic;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.SessionTrackingMode;
import jakarta.servlet.descriptor.JspConfigDescriptor;

import java.io.InputStream;

import java.net.URL;

import java.util.Enumeration;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Mock <strong>ServletContext</strong> object for low-level unit tests of
 * Struts controller components. Coarser grained tests should be implemented
 * in terms of the Cactus framework, instead of the mock object classes.
 * </p>
 *
 * <p>
 * <strong>WARNING</strong> - Only the minimal set of methods needed to
 * create unit tests is provided, plus additional methods to configure this
 * object as necessary. Methods for unsupported operations will throw
 * <code>UnsupportedOperationException</code>.
 * </p>
 *
 * <p>
 * <strong>WARNING</strong> - Because unit tests operate in a single
 * threaded environment, no synchronization is performed.
 * </p>
 *
 * @version $Rev: 471754 $ $Date: 2005-05-07 12:11:38 -0400 (Sat, 07 May 2005)
 *          $
 */
public class MockServletContext implements ServletContext {
    // ----------------------------------------------------- Instance Variables

    /**
     * <p>
     * The set of servlet context attributes.
     * </p>
     */
    protected HashMap attributes = new HashMap();

    /**
     * <p>
     * Default destination for <code>LOG()</code> output.
     * </p>
     */
    protected Log log = LogFactory.getLog(MockServletContext.class);

    /**
     * <p>
     * The set of context initialization parameters.
     * </p>
     */
    protected HashMap parameters = new HashMap();

    // --------------------------------------------------------- Public Methods
    public void addInitParameter(String name, String value) {
        parameters.put(name, value);
    }

    public void setLog(Log log) {
        this.log = log;
    }

    // ------------------------------------------------- ServletContext Methods
    public Object getAttribute(String name) {
        return (attributes.get(name));
    }

    public Enumeration getAttributeNames() {
        return (new MockEnumeration(attributes.keySet().iterator()));
    }

    public ServletContext getContext(String uripath) {
        throw new UnsupportedOperationException();
    }

    public String getInitParameter(String name) {
        return ((String) parameters.get(name));
    }

    public Enumeration getInitParameterNames() {
        return (new MockEnumeration(parameters.keySet().iterator()));
    }

    public int getMajorVersion() {
        return (2);
    }

    public String getMimeType(String file) {
        throw new UnsupportedOperationException();
    }

    public int getMinorVersion() {
        return (3);
    }

    public RequestDispatcher getNamedDispatcher(String name) {
        throw new UnsupportedOperationException();
    }

    public String getRealPath(String path) {
        throw new UnsupportedOperationException();
    }

    public RequestDispatcher getRequestDispatcher(String path) {
        throw new UnsupportedOperationException();
    }

    public URL getResource(String path) {
        return this.getClass().getResource(path);

        // throw new UnsupportedOperationException();
    }

    public InputStream getResourceAsStream(String path) {
        return this.getClass().getResourceAsStream(path);

        // throw new UnsupportedOperationException();
    }

    public Set getResourcePaths(String path) {
        throw new UnsupportedOperationException();
    }

    public String getServerInfo() {
        return ("MockServletContext/$Version$");
    }

    public Servlet getServlet(String name) {
        throw new UnsupportedOperationException();
    }

    public String getServletContextName() {
        return (getServerInfo());
    }

    public Enumeration getServletNames() {
        throw new UnsupportedOperationException();
    }

    public Enumeration getServlets() {
        throw new UnsupportedOperationException();
    }

    public void log(Exception exception, String message) {
        log(message, exception);
    }

    public void log(String message) {
        log.info(message);
    }

    public void log(String message, Throwable throwable) {
        log.error(message, throwable);
    }

    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    public void setAttribute(String name, Object value) {
        if (value == null) {
            attributes.remove(name);
        } else {
            attributes.put(name, value);
        }
    }

    @Override
    public Dynamic addFilter(String arg0, String arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFilter'");
    }

    @Override
    public Dynamic addFilter(String arg0, Filter arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFilter'");
    }

    @Override
    public Dynamic addFilter(String arg0, Class<? extends Filter> arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFilter'");
    }

    @Override
    public jakarta.servlet.ServletRegistration.Dynamic addJspFile(String arg0, String arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addJspFile'");
    }

    @Override
    public void addListener(String arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addListener'");
    }

    @Override
    public <T extends EventListener> void addListener(T arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addListener'");
    }

    @Override
    public void addListener(Class<? extends EventListener> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addListener'");
    }

    @Override
    public jakarta.servlet.ServletRegistration.Dynamic addServlet(String arg0, String arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addServlet'");
    }

    @Override
    public jakarta.servlet.ServletRegistration.Dynamic addServlet(String arg0, Servlet arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addServlet'");
    }

    @Override
    public jakarta.servlet.ServletRegistration.Dynamic addServlet(String arg0, Class<? extends Servlet> arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addServlet'");
    }

    @Override
    public <T extends Filter> T createFilter(Class<T> arg0) throws ServletException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createFilter'");
    }

    @Override
    public <T extends EventListener> T createListener(Class<T> arg0) throws ServletException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createListener'");
    }

    @Override
    public <T extends Servlet> T createServlet(Class<T> arg0) throws ServletException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createServlet'");
    }

    @Override
    public void declareRoles(String... arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'declareRoles'");
    }

    @Override
    public ClassLoader getClassLoader() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getClassLoader'");
    }

    @Override
    public String getContextPath() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getContextPath'");
    }

    @Override
    public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDefaultSessionTrackingModes'");
    }

    @Override
    public int getEffectiveMajorVersion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEffectiveMajorVersion'");
    }

    @Override
    public int getEffectiveMinorVersion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEffectiveMinorVersion'");
    }

    @Override
    public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEffectiveSessionTrackingModes'");
    }

    @Override
    public FilterRegistration getFilterRegistration(String arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFilterRegistration'");
    }

    @Override
    public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFilterRegistrations'");
    }

    @Override
    public JspConfigDescriptor getJspConfigDescriptor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJspConfigDescriptor'");
    }

    @Override
    public String getRequestCharacterEncoding() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRequestCharacterEncoding'");
    }

    @Override
    public String getResponseCharacterEncoding() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResponseCharacterEncoding'");
    }

    @Override
    public ServletRegistration getServletRegistration(String arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServletRegistration'");
    }

    @Override
    public Map<String, ? extends ServletRegistration> getServletRegistrations() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServletRegistrations'");
    }

    @Override
    public SessionCookieConfig getSessionCookieConfig() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSessionCookieConfig'");
    }

    @Override
    public int getSessionTimeout() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSessionTimeout'");
    }

    @Override
    public String getVirtualServerName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVirtualServerName'");
    }

    @Override
    public boolean setInitParameter(String arg0, String arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setInitParameter'");
    }

    @Override
    public void setRequestCharacterEncoding(String arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRequestCharacterEncoding'");
    }

    @Override
    public void setResponseCharacterEncoding(String arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setResponseCharacterEncoding'");
    }

    @Override
    public void setSessionTimeout(int arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSessionTimeout'");
    }

    @Override
    public void setSessionTrackingModes(Set<SessionTrackingMode> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSessionTrackingModes'");
    }
}
