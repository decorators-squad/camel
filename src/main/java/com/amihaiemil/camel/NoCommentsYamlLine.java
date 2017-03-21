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

/**
 * A decorator class for YamlLine to remove comments from a given YamlLine.
 * @author Sherif Waly (sherifwaly95@gmail.com)
 * @version $Id$
 * @since 1.0.0
 *
 */
final class NoCommentsYamlLine implements YamlLine {

    /**
     * Original line.
     */
    private YamlLine line;
    
    /**
     * Ctor.
     * @param line Original YamlLine
     */
    NoCommentsYamlLine(final YamlLine line) {
        this.line = line;
    }
    
    @Override
    public int compareTo(final YamlLine other) {
        return this.line.compareTo(other);
    }

    @Override
    public String trimmed() {
        String string = this.line.trimmed();
        int i = 0;
        while(i < string.length()) {
            if(string.charAt(i) == '#') {
                string = string.substring(0, i);
                break;
            } else if(string.charAt(i) == '"') {
                i++;
                while(i < string.length() && string.charAt(i) != '"') {
                    i++;
                }
            } else {
                i++;
            }
        }
        return string.trim();
    }

    @Override
    public int number() {
        return this.line.number();
    }

    @Override
    public int indentation() {
        return this.line.indentation();
    }

    @Override
    public boolean hasNestedNode() {
        return this.line.hasNestedNode();
    }

}
