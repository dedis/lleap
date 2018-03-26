package ch.epfl.dedis.lib;

import ch.epfl.dedis.lib.exception.CothorityCryptoException;
import ch.epfl.dedis.lib.exception.CothorityException;
import ch.epfl.dedis.proto.SkipBlockProto;
import com.google.protobuf.InvalidProtocolBufferException;

import java.net.URISyntaxException;

/**
 * SkipBlock is a wrapper around the protobuf SkipBlock class. It is mainly used to serialize the genesis block for
 * storage.
 */
public class SkipBlock {
    private SkipBlockProto.SkipBlock skipBlock;

    public SkipBlock(SkipBlockProto.SkipBlock skipBlock) {
        this.skipBlock = skipBlock;
    }

    public SkipBlock(byte[] sb) throws CothorityException {
        try {
            this.skipBlock = SkipBlockProto.SkipBlock.parseFrom(sb);
        } catch (InvalidProtocolBufferException e) {
            throw new CothorityException(e);
        }
    }

    public SkipBlockProto.SkipBlock getProto(){
        return skipBlock;
    }

    /**
     * Returns the serialized skipblock.
     */
    public byte[] toByteArray() {
        return this.skipBlock.toByteArray();
    }

    public byte[] getHash() {
        return skipBlock.getHash().toByteArray();
    }

    public SkipblockId getId() throws CothorityCryptoException {
        return new SkipblockId(this.getHash());
    }

    /**
     * Gets the roster from the skipblock.
     */
    public Roster getRoster() throws CothorityException {
        try {
            return new Roster(skipBlock.getRoster());
        } catch (URISyntaxException e) {
            throw new CothorityException(e);
        }
    }
}
