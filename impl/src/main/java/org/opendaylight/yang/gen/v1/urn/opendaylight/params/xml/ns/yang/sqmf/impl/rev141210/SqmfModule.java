package org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sqmf.impl.rev141210;

import sqmf.impl.SqmfProvider;

public class SqmfModule extends org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sqmf.impl.rev141210.AbstractSqmfModule {
    public SqmfModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver) {
        super(identifier, dependencyResolver);
    }

    public SqmfModule(org.opendaylight.controller.config.api.ModuleIdentifier identifier, org.opendaylight.controller.config.api.DependencyResolver dependencyResolver, org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sqmf.impl.rev141210.SqmfModule oldModule, java.lang.AutoCloseable oldInstance) {
        super(identifier, dependencyResolver, oldModule, oldInstance);
    }

    @Override
    public void customValidation() {
        // add custom validation form module attributes here.
    }

    @Override
    public java.lang.AutoCloseable createInstance() {
        SqmfProvider provider = new SqmfProvider();
        getBrokerDependency().registerProvider(provider);
        return provider;
    }

}
