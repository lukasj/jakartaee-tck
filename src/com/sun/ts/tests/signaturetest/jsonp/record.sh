#!/bin/sh
#
# Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
#
# This program and the accompanying materials are made available under the
# terms of the Eclipse Public License v. 2.0, which is available at
# http://www.eclipse.org/legal/epl-2.0.
#
# This Source Code may also be made available under the following Secondary
# Licenses when the conditions for such availability set forth in the
# Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
# version 2 with the GNU Classpath Exception, which is available at
# https://www.gnu.org/software/classpath/license.html.
#
# SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
#

#
# $Id$
#

PATHSEP=:
PWD=`pwd`
JSONP_CLASSES=/files/jsonp/ri/lib/jakarta.json-1.0-SNAPSHOT.jar
cd ../signature-repository
ant -f ../record-build.xml -Drecorder.type=sigtest -Dsig.source=${JSONP_CLASSES}:$JAVA_HOME/jre/lib/rt.jar \
       -Dmap.file=$TS_HOME/install/jsonp/bin/sig-test.map record.sig.batch
cd $TS_HOME/install/jsonp/bin
rm -f sig-test-pkg-list.txt.bak sig-test-pkg-list.txt
svn update
cd $PWD
