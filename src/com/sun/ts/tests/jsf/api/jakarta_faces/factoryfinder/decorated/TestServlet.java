/*
 * Copyright (c) 2009, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */
package com.sun.ts.tests.jsf.api.jakarta_faces.factoryfinder.decorated;

import java.io.IOException;
import java.io.PrintWriter;

import com.sun.ts.tests.jsf.common.factories.TCKDecoratedContextFactory;
import com.sun.ts.tests.jsf.common.servlets.FactoryTCKServlet;

import jakarta.faces.FactoryFinder;
import jakarta.faces.context.FacesContextFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet extends FactoryTCKServlet {

  public void getFactoryDecoratedTest(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    PrintWriter pw = response.getWriter();

    String expectFactNames = "com.sun.ts.tests.jsf.common.factories."
        + "TCKContextFactoryFour and com.sun.ts.tests.jsf.common."
        + "factories.TCKContextFactoryThree";

    try {
      FacesContextFactory fcf = (FacesContextFactory) FactoryFinder
          .getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);

      TCKDecoratedContextFactory tckFactory = (TCKDecoratedContextFactory) fcf
          .getWrapped();
      String factNameFour = tckFactory.getClass().getCanonicalName();
      String factNameThree = tckFactory.getParent();

      if (factNameThree.contains("TCKContextFactoryThree")
          && factNameFour.contains("TCKContextFactoryFour")) {
        pw.println("Test PASSED");
      } else {
        pw.println("FacesContext Were not Decorated in correct order.");
        pw.println("Found: " + factNameThree + " And " + factNameFour);
        pw.println("Expected: " + expectFactNames);
        pw.println("Test FAILED.");
      }

    } catch (Exception e) {
      pw.println("Test FAILED.");
      pw.println(e.toString());
    }
  }
}
