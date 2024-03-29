package ch.epfl.dedis.lib;

import ch.epfl.dedis.lib.crypto.Ed25519;
import ch.epfl.dedis.lib.crypto.Point;
import ch.epfl.dedis.lib.exception.CothorityCommunicationException;
import ch.epfl.dedis.proto.RosterProto;
import ch.epfl.dedis.proto.ServerIdentityProto;
import com.google.protobuf.ByteString;
import com.moandjiezana.toml.Toml;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * dedis/lib
 * Roster.java
 * Purpose: A list of ServerIdentities make up a roster that can be used as a temporary
 * cothority.
 */

public class Roster {
    private List<ServerIdentity> nodes = new ArrayList<>();
    private Point aggregate; // TODO: can we find better name for it? like aggregatePublicKey or aggregatedKey?

    public Roster(List<ServerIdentity> servers) {
        nodes.addAll(servers);
        this.updateAggregate();
    }

    public Roster(RosterProto.Roster roster) throws URISyntaxException {
        List<ServerIdentity> sids = new ArrayList<>();
        for (ServerIdentityProto.ServerIdentity sid : roster.getListList()) {
            sids.add(new ServerIdentity(sid));
        }
        nodes.addAll(sids);
        this.updateAggregate();
    }

    private void updateAggregate() {
        for (final ServerIdentity serverIdentity : nodes) {
            if (aggregate == null) {
                // TODO: it will be much better if there is some kind of 'zero' element for Point type. Is it possible to use just a new created Point
                aggregate = serverIdentity.Public;
            } else {
                aggregate = aggregate.add(serverIdentity.Public);
            }
        }
    }

    public List<ServerIdentity> getNodes() {
        return nodes;
    }

    public RosterProto.Roster getProto() {
        RosterProto.Roster.Builder r = RosterProto.Roster.newBuilder();
        r.setId(ByteString.copyFrom(Ed25519.uuid4()));
        for (ServerIdentity si : nodes)
            r.addList(si.getProto());
        r.setAggregate(aggregate.toProto());

        return r.build();
    }

    public ByteString sendMessage(String path, com.google.protobuf.GeneratedMessageV3 proto) throws CothorityCommunicationException {
        // TODO - fetch a random node.
        return ByteString.copyFrom(nodes.get(0).SendMessage(path, proto.toByteArray()));
    }

    public static Roster FromToml(String groupToml) {
        Toml toml = new Toml().read(groupToml);
        List<ServerIdentity> cothority = new ArrayList<>();
        List<Toml> servers = toml.getTables("servers");

        for (Toml s : servers) {
            try {
                cothority.add(new ServerIdentity(s));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return new Roster(cothority);
    }

    public Point getAggregate() {
        return this.aggregate;
    }
}
