/*
 * Copyright (c) 2016, 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

package org.eclipse.yasson.defaultmapping.dates.model;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;

/**
 * @author Roman Grigoriadi
 */
@JsonbDateFormat(value = "X z E MMMM dd-MM-yyyy HH:mm:ss", locale = "fr")
public class ClassLevelDateAnnotation extends ClassLevelDateAnnotationParent {

    public ZonedDateTime zonedDateTime;

    public Calendar calendar;

    @JsonbDateFormat(value = JsonbDateFormat.DEFAULT_FORMAT)
    public ZonedDateTime defaultZoned;

}
