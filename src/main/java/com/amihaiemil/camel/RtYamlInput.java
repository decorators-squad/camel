/**
 * Copyright (c) 2016-2017, Mihai Emil Andronache
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 * Neither the name of the copyright holder nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
package com.amihaiemil.camel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Implementation for {@link YamlInput}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id: d6cbc8b7d1ddd6d77ed825ebaa9e79fa223ff65f $
 * @since 1.0.0
 */
final class RtYamlInput implements YamlInput {

    /**
     * Source of the input.
     */
    private InputStream source;

    /**
     * Ctor.
     * @param source Given source.
     */
    RtYamlInput(final InputStream source) {
        this.source = source;
    }

    @Override
    public YamlMapping readYamlMapping() {
        return null;
    }

    @Override
    public YamlSequence readYamlSequence() {
        return null;
    }

    /**
     * Read the input's lines.
     * @return YamlLines
     * @throws IOException If something goes wrong while reading the input.
     */
    private YamlLines readInput() throws IOException {
        Queue<YamlLine> lines = new ConcurrentLinkedQueue<>();
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.source)
            )
        ) {
            String line;
            int number = 0;
            while ((line = reader.readLine()) != null) {
                lines.add(new RtYamlLine(line, number));
                number++;
            }
        }
        return null;
    }
}
