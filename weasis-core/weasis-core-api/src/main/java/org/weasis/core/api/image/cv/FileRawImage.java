/*******************************************************************************
 * Copyright (c) 2016 Weasis Team and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Roduit - initial API and implementation
 *******************************************************************************/
package org.weasis.core.api.image.cv;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.weasis.core.api.media.data.PlanarImage;

public class FileRawImage {
    public static final int HEADER_LENGTH = 46;

    private final File file;

    public FileRawImage(File file) {
        this.file = Objects.requireNonNull(file);
    }

    public File getFile() {
        return file;
    }

    public ImageCV read() throws IOException {
        return ImageProcessor.readImageWithCvException(file);
    }

    public boolean write(PlanarImage mat) {
        return ImageProcessor.writeImage(mat.toMat(), file);
    }
}