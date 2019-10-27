/*******************************************************************************
 * Copyright (c) 2016, 2019 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * Roman Grigoriadi
 ******************************************************************************/

package org.eclipse.yasson.internal.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import java.util.Map;
import java.util.HashMap;

import javax.json.bind.JsonbException;

import org.eclipse.yasson.internal.properties.Messages;
import org.eclipse.yasson.internal.properties.MessageKeys;

/**
 * Annotation holder for fields, getters and setters.
 *
 * @param <T> annotated element
 */
public class JsonbAnnotatedElement<T extends AnnotatedElement> {
    private final Map<Class<? extends Annotation>, Annotation> annotations;
    private final T element;

    /**
     * Creates a new instance.
     *
     * @param element Element.
     */
    public JsonbAnnotatedElement(T element) {
        Map<Class<? extends Annotation>, Annotation> annotations = new HashMap<>();
        
        for (Annotation ann : element.getAnnotations()) {
            annotations.put(ann.annotationType(), ann);
        }
        this.annotations = annotations;
        this.element = element;
    }

    /**
     * Gets element.
     *
     * @return Element.
     */
    public T getElement() {
        return element;
    }
    
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return annotationClass.cast(annotations.get(annotationClass));
    }
    
    public Annotation[] getAnnotations() {
        return annotations.values().toArray(new Annotation[0]);
    }
    
    /**
     * Adds annotation.
     *
     * @param annotation Annotation to add.
     */
    public void putAnnotation(Annotation annotation) {
        if (annotations.containsKey(annotation.annotationType())) {
            throw new JsonbException(Messages.getMessage(MessageKeys.INTERNAL_ERROR,
                                                         "Annotation already present: " + annotation));
        }
        annotations.put(annotation.annotationType(), annotation);
    }
}
