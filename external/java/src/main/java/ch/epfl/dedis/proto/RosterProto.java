// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: roster.proto

package ch.epfl.dedis.proto;

public final class RosterProto {
  private RosterProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RosterOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Roster)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required bytes id = 1;</code>
     */
    boolean hasId();
    /**
     * <code>required bytes id = 1;</code>
     */
    com.google.protobuf.ByteString getId();

    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    java.util.List<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity> 
        getListList();
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity getList(int index);
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    int getListCount();
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    java.util.List<? extends ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder> 
        getListOrBuilderList();
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder getListOrBuilder(
        int index);

    /**
     * <code>required bytes aggregate = 3;</code>
     */
    boolean hasAggregate();
    /**
     * <code>required bytes aggregate = 3;</code>
     */
    com.google.protobuf.ByteString getAggregate();
  }
  /**
   * Protobuf type {@code Roster}
   */
  public  static final class Roster extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Roster)
      RosterOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Roster.newBuilder() to construct.
    private Roster(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Roster() {
      id_ = com.google.protobuf.ByteString.EMPTY;
      list_ = java.util.Collections.emptyList();
      aggregate_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Roster(
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
              id_ = input.readBytes();
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                list_ = new java.util.ArrayList<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity>();
                mutable_bitField0_ |= 0x00000002;
              }
              list_.add(
                  input.readMessage(ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.PARSER, extensionRegistry));
              break;
            }
            case 26: {
              bitField0_ |= 0x00000002;
              aggregate_ = input.readBytes();
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
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          list_ = java.util.Collections.unmodifiableList(list_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ch.epfl.dedis.proto.RosterProto.internal_static_Roster_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ch.epfl.dedis.proto.RosterProto.internal_static_Roster_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ch.epfl.dedis.proto.RosterProto.Roster.class, ch.epfl.dedis.proto.RosterProto.Roster.Builder.class);
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString id_;
    /**
     * <code>required bytes id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required bytes id = 1;</code>
     */
    public com.google.protobuf.ByteString getId() {
      return id_;
    }

    public static final int LIST_FIELD_NUMBER = 2;
    private java.util.List<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity> list_;
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    public java.util.List<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity> getListList() {
      return list_;
    }
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    public java.util.List<? extends ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder> 
        getListOrBuilderList() {
      return list_;
    }
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    public int getListCount() {
      return list_.size();
    }
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity getList(int index) {
      return list_.get(index);
    }
    /**
     * <code>repeated .ServerIdentity list = 2;</code>
     */
    public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder getListOrBuilder(
        int index) {
      return list_.get(index);
    }

    public static final int AGGREGATE_FIELD_NUMBER = 3;
    private com.google.protobuf.ByteString aggregate_;
    /**
     * <code>required bytes aggregate = 3;</code>
     */
    public boolean hasAggregate() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required bytes aggregate = 3;</code>
     */
    public com.google.protobuf.ByteString getAggregate() {
      return aggregate_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasAggregate()) {
        memoizedIsInitialized = 0;
        return false;
      }
      for (int i = 0; i < getListCount(); i++) {
        if (!getList(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, id_);
      }
      for (int i = 0; i < list_.size(); i++) {
        output.writeMessage(2, list_.get(i));
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(3, aggregate_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, id_);
      }
      for (int i = 0; i < list_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, list_.get(i));
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, aggregate_);
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
      if (!(obj instanceof ch.epfl.dedis.proto.RosterProto.Roster)) {
        return super.equals(obj);
      }
      ch.epfl.dedis.proto.RosterProto.Roster other = (ch.epfl.dedis.proto.RosterProto.Roster) obj;

      boolean result = true;
      result = result && (hasId() == other.hasId());
      if (hasId()) {
        result = result && getId()
            .equals(other.getId());
      }
      result = result && getListList()
          .equals(other.getListList());
      result = result && (hasAggregate() == other.hasAggregate());
      if (hasAggregate()) {
        result = result && getAggregate()
            .equals(other.getAggregate());
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
      if (hasId()) {
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + getId().hashCode();
      }
      if (getListCount() > 0) {
        hash = (37 * hash) + LIST_FIELD_NUMBER;
        hash = (53 * hash) + getListList().hashCode();
      }
      if (hasAggregate()) {
        hash = (37 * hash) + AGGREGATE_FIELD_NUMBER;
        hash = (53 * hash) + getAggregate().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ch.epfl.dedis.proto.RosterProto.Roster parseFrom(
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
    public static Builder newBuilder(ch.epfl.dedis.proto.RosterProto.Roster prototype) {
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
     * Protobuf type {@code Roster}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Roster)
        ch.epfl.dedis.proto.RosterProto.RosterOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ch.epfl.dedis.proto.RosterProto.internal_static_Roster_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ch.epfl.dedis.proto.RosterProto.internal_static_Roster_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ch.epfl.dedis.proto.RosterProto.Roster.class, ch.epfl.dedis.proto.RosterProto.Roster.Builder.class);
      }

      // Construct using ch.epfl.dedis.proto.RosterProto.Roster.newBuilder()
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
          getListFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        id_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        if (listBuilder_ == null) {
          list_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          listBuilder_.clear();
        }
        aggregate_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ch.epfl.dedis.proto.RosterProto.internal_static_Roster_descriptor;
      }

      public ch.epfl.dedis.proto.RosterProto.Roster getDefaultInstanceForType() {
        return ch.epfl.dedis.proto.RosterProto.Roster.getDefaultInstance();
      }

      public ch.epfl.dedis.proto.RosterProto.Roster build() {
        ch.epfl.dedis.proto.RosterProto.Roster result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ch.epfl.dedis.proto.RosterProto.Roster buildPartial() {
        ch.epfl.dedis.proto.RosterProto.Roster result = new ch.epfl.dedis.proto.RosterProto.Roster(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (listBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002)) {
            list_ = java.util.Collections.unmodifiableList(list_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.list_ = list_;
        } else {
          result.list_ = listBuilder_.build();
        }
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000002;
        }
        result.aggregate_ = aggregate_;
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
        if (other instanceof ch.epfl.dedis.proto.RosterProto.Roster) {
          return mergeFrom((ch.epfl.dedis.proto.RosterProto.Roster)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ch.epfl.dedis.proto.RosterProto.Roster other) {
        if (other == ch.epfl.dedis.proto.RosterProto.Roster.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (listBuilder_ == null) {
          if (!other.list_.isEmpty()) {
            if (list_.isEmpty()) {
              list_ = other.list_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureListIsMutable();
              list_.addAll(other.list_);
            }
            onChanged();
          }
        } else {
          if (!other.list_.isEmpty()) {
            if (listBuilder_.isEmpty()) {
              listBuilder_.dispose();
              listBuilder_ = null;
              list_ = other.list_;
              bitField0_ = (bitField0_ & ~0x00000002);
              listBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getListFieldBuilder() : null;
            } else {
              listBuilder_.addAllMessages(other.list_);
            }
          }
        }
        if (other.hasAggregate()) {
          setAggregate(other.getAggregate());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          return false;
        }
        if (!hasAggregate()) {
          return false;
        }
        for (int i = 0; i < getListCount(); i++) {
          if (!getList(i).isInitialized()) {
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ch.epfl.dedis.proto.RosterProto.Roster parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ch.epfl.dedis.proto.RosterProto.Roster) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private com.google.protobuf.ByteString id_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required bytes id = 1;</code>
       */
      public com.google.protobuf.ByteString getId() {
        return id_;
      }
      /**
       * <code>required bytes id = 1;</code>
       */
      public Builder setId(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }

      private java.util.List<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity> list_ =
        java.util.Collections.emptyList();
      private void ensureListIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          list_ = new java.util.ArrayList<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity>(list_);
          bitField0_ |= 0x00000002;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder> listBuilder_;

      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public java.util.List<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity> getListList() {
        if (listBuilder_ == null) {
          return java.util.Collections.unmodifiableList(list_);
        } else {
          return listBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public int getListCount() {
        if (listBuilder_ == null) {
          return list_.size();
        } else {
          return listBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity getList(int index) {
        if (listBuilder_ == null) {
          return list_.get(index);
        } else {
          return listBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder setList(
          int index, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity value) {
        if (listBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureListIsMutable();
          list_.set(index, value);
          onChanged();
        } else {
          listBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder setList(
          int index, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder builderForValue) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.set(index, builderForValue.build());
          onChanged();
        } else {
          listBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder addList(ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity value) {
        if (listBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureListIsMutable();
          list_.add(value);
          onChanged();
        } else {
          listBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder addList(
          int index, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity value) {
        if (listBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureListIsMutable();
          list_.add(index, value);
          onChanged();
        } else {
          listBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder addList(
          ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder builderForValue) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.add(builderForValue.build());
          onChanged();
        } else {
          listBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder addList(
          int index, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder builderForValue) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.add(index, builderForValue.build());
          onChanged();
        } else {
          listBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder addAllList(
          java.lang.Iterable<? extends ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity> values) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, list_);
          onChanged();
        } else {
          listBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder clearList() {
        if (listBuilder_ == null) {
          list_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          listBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public Builder removeList(int index) {
        if (listBuilder_ == null) {
          ensureListIsMutable();
          list_.remove(index);
          onChanged();
        } else {
          listBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder getListBuilder(
          int index) {
        return getListFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder getListOrBuilder(
          int index) {
        if (listBuilder_ == null) {
          return list_.get(index);  } else {
          return listBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public java.util.List<? extends ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder> 
           getListOrBuilderList() {
        if (listBuilder_ != null) {
          return listBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(list_);
        }
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder addListBuilder() {
        return getListFieldBuilder().addBuilder(
            ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.getDefaultInstance());
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder addListBuilder(
          int index) {
        return getListFieldBuilder().addBuilder(
            index, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.getDefaultInstance());
      }
      /**
       * <code>repeated .ServerIdentity list = 2;</code>
       */
      public java.util.List<ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder> 
           getListBuilderList() {
        return getListFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder> 
          getListFieldBuilder() {
        if (listBuilder_ == null) {
          listBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentity.Builder, ch.epfl.dedis.proto.ServerIdentityProto.ServerIdentityOrBuilder>(
                  list_,
                  ((bitField0_ & 0x00000002) == 0x00000002),
                  getParentForChildren(),
                  isClean());
          list_ = null;
        }
        return listBuilder_;
      }

      private com.google.protobuf.ByteString aggregate_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>required bytes aggregate = 3;</code>
       */
      public boolean hasAggregate() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required bytes aggregate = 3;</code>
       */
      public com.google.protobuf.ByteString getAggregate() {
        return aggregate_;
      }
      /**
       * <code>required bytes aggregate = 3;</code>
       */
      public Builder setAggregate(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        aggregate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bytes aggregate = 3;</code>
       */
      public Builder clearAggregate() {
        bitField0_ = (bitField0_ & ~0x00000004);
        aggregate_ = getDefaultInstance().getAggregate();
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


      // @@protoc_insertion_point(builder_scope:Roster)
    }

    // @@protoc_insertion_point(class_scope:Roster)
    private static final ch.epfl.dedis.proto.RosterProto.Roster DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ch.epfl.dedis.proto.RosterProto.Roster();
    }

    public static ch.epfl.dedis.proto.RosterProto.Roster getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    @java.lang.Deprecated public static final com.google.protobuf.Parser<Roster>
        PARSER = new com.google.protobuf.AbstractParser<Roster>() {
      public Roster parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Roster(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Roster> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Roster> getParserForType() {
      return PARSER;
    }

    public ch.epfl.dedis.proto.RosterProto.Roster getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Roster_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Roster_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014roster.proto\032\025server-identity.proto\"F\n" +
      "\006Roster\022\n\n\002id\030\001 \002(\014\022\035\n\004list\030\002 \003(\0132\017.Serv" +
      "erIdentity\022\021\n\taggregate\030\003 \002(\014B\"\n\023ch.epfl" +
      ".dedis.protoB\013RosterProto"
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
          ch.epfl.dedis.proto.ServerIdentityProto.getDescriptor(),
        }, assigner);
    internal_static_Roster_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Roster_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Roster_descriptor,
        new java.lang.String[] { "Id", "List", "Aggregate", });
    ch.epfl.dedis.proto.ServerIdentityProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
