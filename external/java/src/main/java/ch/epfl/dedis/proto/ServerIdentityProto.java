// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server-identity.proto

package ch.epfl.dedis.proto;

public final class ServerIdentityProto {
  private ServerIdentityProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ServerIdentityOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ServerIdentity)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes public = 1;</code>
     */
    boolean hasPublic();
    /**
     * <code>required bytes public = 1;</code>
     */
    com.google.protobuf.ByteString getPublic();

    /**
     * <code>required bytes id = 2;</code>
     */
    boolean hasId();
    /**
     * <code>required bytes id = 2;</code>
     */
    com.google.protobuf.ByteString getId();

    /**
     * <code>required string address = 3;</code>
     */
    boolean hasAddress();
    /**
     * <code>required string address = 3;</code>
     */
    java.lang.String getAddress();
    /**
     * <code>required string address = 3;</code>
     */
    com.google.protobuf.ByteString
        getAddressBytes();

    /**
     * <code>required string description = 4;</code>
     */
    boolean hasDescription();
    /**
     * <code>required string description = 4;</code>
     */
    java.lang.String getDescription();
    /**
     * <code>required string description = 4;</code>
     */
    com.google.protobuf.ByteString
        getDescriptionBytes();
  }
  /**
   * Protobuf type {@code ServerIdentity}
   */
  public  static final class ServerIdentity extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ServerIdentity)
      ServerIdentityOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ServerIdentity.newBuilder() to construct.
    private ServerIdentity(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ServerIdentity() {
      public_ = com.google.protobuf.ByteString.EMPTY;
      id_ = com.google.protobuf.ByteString.EMPTY;
      address_ = "";
      description_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ServerIdentity(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              public_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              id_ = input.readBytes();
              break;
            }
            case 26: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000004;
              address_ = bs;
              break;
            }
            case 34: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000008;
              description_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ch.epfl.dedis.proto.ServerIdentityProto.internal_static_ServerIdentity_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ch.epfl.dedis.proto.ServerIdentityProto.internal_static_ServerIdentity_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.class, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder.class);
    }

    private int bitField0_;
    public static final int PUBLIC_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString public_;
    /**
     * <code>required bytes public = 1;</code>
     */
    public boolean hasPublic() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes public = 1;</code>
     */
    public com.google.protobuf.ByteString getPublic() {
      return public_;
    }

    public static final int ID_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString id_;
    /**
     * <code>required bytes id = 2;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes id = 2;</code>
     */
    public com.google.protobuf.ByteString getId() {
      return id_;
    }

    public static final int ADDRESS_FIELD_NUMBER = 3;
    private volatile java.lang.Object address_;
    /**
     * <code>required string address = 3;</code>
     */
    public boolean hasAddress() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required string address = 3;</code>
     */
    public java.lang.String getAddress() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          address_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string address = 3;</code>
     */
    public com.google.protobuf.ByteString
        getAddressBytes() {
      java.lang.Object ref = address_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        address_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    private volatile java.lang.Object description_;
    /**
     * <code>required string description = 4;</code>
     */
    public boolean hasDescription() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required string description = 4;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          description_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string description = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasPublic()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasAddress()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasDescription()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, public_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, id_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, address_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, description_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, public_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, id_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, address_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, description_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity)) {
        return super.equals(obj);
      }
      ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity other = (ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity) obj;

      boolean result = true;
      result = result && (hasPublic() == other.hasPublic());
      if (hasPublic()) {
        result = result && getPublic()
            .equals(other.getPublic());
      }
      result = result && (hasId() == other.hasId());
      if (hasId()) {
        result = result && getId()
            .equals(other.getId());
      }
      result = result && (hasAddress() == other.hasAddress());
      if (hasAddress()) {
        result = result && getAddress()
            .equals(other.getAddress());
      }
      result = result && (hasDescription() == other.hasDescription());
      if (hasDescription()) {
        result = result && getDescription()
            .equals(other.getDescription());
      }
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasPublic()) {
        hash = (37 * hash) + PUBLIC_FIELD_NUMBER;
        hash = (53 * hash) + getPublic().hashCode();
      }
      if (hasId()) {
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + getId().hashCode();
      }
      if (hasAddress()) {
        hash = (37 * hash) + ADDRESS_FIELD_NUMBER;
        hash = (53 * hash) + getAddress().hashCode();
      }
      if (hasDescription()) {
        hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
        hash = (53 * hash) + getDescription().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ServerIdentity}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ServerIdentity)
        ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ch.epfl.dedis.proto.ServerIdentityProto.internal_static_ServerIdentity_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ch.epfl.dedis.proto.ServerIdentityProto.internal_static_ServerIdentity_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.class, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder.class);
      }

      // Construct using ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        public_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        address_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        description_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ch.epfl.dedis.proto.ServerIdentityProto.internal_static_ServerIdentity_descriptor;
      }

      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity getDefaultInstanceForType() {
        return ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.getDefaultInstance();
      }

      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity build() {
        ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity buildPartial() {
        ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity result = new ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.public_ = public_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.address_ = address_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.description_ = description_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity) {
          return mergeFrom((ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity other) {
        if (other == ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.getDefaultInstance()) return this;
        if (other.hasPublic()) {
          setPublic(other.getPublic());
        }
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasAddress()) {
          bitField0_ |= 0x00000004;
          address_ = other.address_;
          onChanged();
        }
        if (other.hasDescription()) {
          bitField0_ |= 0x00000008;
          description_ = other.description_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasPublic()) {
          return false;
        }
        if (!hasId()) {
          return false;
        }
        if (!hasAddress()) {
          return false;
        }
        if (!hasDescription()) {
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString public_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes public = 1;</code>
       */
      public boolean hasPublic() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes public = 1;</code>
       */
      public com.google.protobuf.ByteString getPublic() {
        return public_;
      }
      /**
       * <code>required bytes public = 1;</code>
       */
      public Builder setPublic(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        public_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes public = 1;</code>
       */
      public Builder clearPublic() {
        bitField0_ = (bitField0_ & ~0x00000001);
        public_ = getDefaultInstance().getPublic();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString id_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes id = 2;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required bytes id = 2;</code>
       */
      public com.google.protobuf.ByteString getId() {
        return id_;
      }
      /**
       * <code>required bytes id = 2;</code>
       */
      public Builder setId(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes id = 2;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000002);
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }

      private java.lang.Object address_ = "";
      /**
       * <code>required string address = 3;</code>
       */
      public boolean hasAddress() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required string address = 3;</code>
       */
      public java.lang.String getAddress() {
        java.lang.Object ref = address_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            address_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string address = 3;</code>
       */
      public com.google.protobuf.ByteString
          getAddressBytes() {
        java.lang.Object ref = address_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          address_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string address = 3;</code>
       */
      public Builder setAddress(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        address_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string address = 3;</code>
       */
      public Builder clearAddress() {
        bitField0_ = (bitField0_ & ~0x00000004);
        address_ = getDefaultInstance().getAddress();
        onChanged();
        return this;
      }
      /**
       * <code>required string address = 3;</code>
       */
      public Builder setAddressBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        address_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object description_ = "";
      /**
       * <code>required string description = 4;</code>
       */
      public boolean hasDescription() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required string description = 4;</code>
       */
      public java.lang.String getDescription() {
        java.lang.Object ref = description_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            description_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string description = 4;</code>
       */
      public com.google.protobuf.ByteString
          getDescriptionBytes() {
        java.lang.Object ref = description_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          description_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string description = 4;</code>
       */
      public Builder setDescription(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        description_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string description = 4;</code>
       */
      public Builder clearDescription() {
        bitField0_ = (bitField0_ & ~0x00000008);
        description_ = getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      /**
       * <code>required string description = 4;</code>
       */
      public Builder setDescriptionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        description_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:ServerIdentity)
    }

    // @@protoc_insertion_point(class_scope:ServerIdentity)
    private static final ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity();
    }

    public static ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<ServerIdentity>
        PARSER = new com.google.protobuf.AbstractParser<ServerIdentity>() {
      public ServerIdentity parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ServerIdentity(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ServerIdentity> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ServerIdentity> getParserForType() {
      return PARSER;
    }

    public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ServerIdentity_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ServerIdentity_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025server-identity.proto\"R\n\016ServerIdentit" +
      "y\022\016\n\006public\030\001 \002(\014\022\n\n\002id\030\002 \002(\014\022\017\n\007address" +
      "\030\003 \002(\t\022\023\n\013description\030\004 \002(\tB*\n\023ch.epfl.d" +
      "edis.protoB\023ServerIdentityProto"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ServerIdentity_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ServerIdentity_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ServerIdentity_descriptor,
        new java.lang.String[] { "Public", "Id", "Address", "Description", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
