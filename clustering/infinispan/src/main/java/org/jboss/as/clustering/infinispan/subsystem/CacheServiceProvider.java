/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.clustering.infinispan.subsystem;

import java.util.Collection;

import org.infinispan.configuration.cache.CacheMode;
import org.jboss.modules.ModuleIdentifier;
import org.jboss.msc.service.ServiceController;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.ServiceTarget;

public interface CacheServiceProvider {
    /**
     * Returns the names of the services installed by this provider
     * @param cluster a cluster name
     * @return a collection of service names
     */
    Collection<ServiceName> getServiceNames(String container, String cache, boolean defaultCache);

    /**
     * Installs services for the specified channel
     * @param target the service target in which to install services
     * @param containerName the cache container name
     * @param cacheName the cache name
     * @param mode the cache mode
     * @param defaultCache true, if this is the default cache of the container, false otherwise
     * @param moduleId the unique identifier of the module upon which these services should operate
     * @return a collection of installed services
     */
    Collection<ServiceController<?>> install(ServiceTarget target, String containerName, String cacheName, CacheMode mode, boolean defaultCache, ModuleIdentifier moduleId);
}
