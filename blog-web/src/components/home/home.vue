<template>
  <div id="home">
    <div class="head">
      <div class="title">
        <div class="title-inner">
          <div class="me">
            <span>
              Snow
            </span>
          </div>
          <div class="navigation">
            <span>Home</span>
            <span>Blog</span>
            <span>Message</span>
          </div>
        </div>
      </div>
      <div class="show">
        <div class="show-inner">
          <div class="me">Snow</div>
          <div class="detail">He is rich enough that wants nothing.</div>
        </div>
      </div>
    </div>
    <div class="main">
      <div :class="classes.mainInnerAppend" class="main-inner">
        <a :class="classes.articleAppend" :href="fileBase+article.imgUrl" class="article"
           v-for="article in article.articles">
          <div class="image-wrapper">
            <img class="image" :src="fileBase+article.imgUrl">
          </div>
          <div class="content">
            <div class="title">{{article.title}}</div>
            <div class="date">{{article.createTime}}</div>
            <div :class="classes.descAppend" class="desc">{{article.content}}</div>
          </div>
        </a>
        <div v-for="n in articlesAppendNum" :class="classes.articleAppend" class="article" v-visible="false"></div>
      </div>
    </div>
    <div class="foot"></div>
  </div>
</template>

<script type="text/ecmascript-6">
  import { mapState, mapActions } from 'vuex'
  export default {
    data () {
      return {
        screenWidth: `${document.documentElement.clientWidth}`,
        classes: {
          articleAppend: '',
          mainInnerAppend: '',
          descAppend: ''
        },
        articlesAppendNum: 0
      }
    },
    computed: {
      ...mapState(['article'])
    },
    created () {
      this.getArticles()
    },
    mounted () {
      const that = this
      window.onresize = () => {
        that.screenWidth = `${document.documentElement.clientWidth}`
        that.updateClasses()
      }
      window.onload = () => {
        that.screenWidth = `${document.documentElement.clientWidth}`
        that.updateClasses()
      }
    },
    destroyed () {},
    methods: {
      ...mapActions(['getArticles']),
      updateClasses () {
        if (this.screenWidth > 1428) {
          this.articlesAppendNum = 3 - this.article.articles.length % 3
          this.classes.articleAppend = 'articleSmall'
          this.classes.mainInnerAppend = 'mainInnerBetween'
          this.classes.descAppend = 'descLineClamp2'
        } else if (this.screenWidth > 958) {
          this.articlesAppendNum = this.article.articles.length % 2
          this.classes.articleAppend = 'articleMiddle'
          this.classes.mainInnerAppend = 'mainInnerBetween'
          this.classes.descAppend = 'descLineClamp4'
        } else {
          this.classes.articleAppend = 'articleLarge'
          this.classes.mainInnerAppend = 'mainInnerCenter'
          this.classes.descAppend = 'descLineClamp8'
        }
      }
    },
    filters: {},
    watch: {}
  }
</script>

<style lang="stylus" rel="stylesheet/stylus">
  @import "../../common/stylus/index.styl"

  *
    color rgba(0, 0, 0, 0.9)

  /*font-family Georgia*/
  a:link {
    text-decoration: none;
  }

  a:active {
    text-decoration: none
  }

  a:hover {
    text-decoration: none;
  }

  a:visited {
    text-decoration: none;
  }

  .head
    bg-image("home_display.jpg")
    .title
      position relative
      height 60px
      background rgba(255, 255, 255, 1)
      .title-inner
        height 40px
        width 85%
        line-height 40px
        margin auto
        padding-top 10px
        vertical-align middle
        .me
          display inline-block
          font-size 25px
          font-weight 500
        .navigation
          float right
          display inline-block
          font-weight 200
          span
            display inline-block
            width 60px
    .show
      background rgba(0, 0, 0, 0.5)
      color rgba(255, 255, 255, 1.0)
      .show-inner
        padding 10% 0
        text-align center
        .me
          font-size 30px
          font-weight 600

  .main
    background-color #f8f8f8
    .main-inner
      display flex
      margin auto
      padding-top 50px
      width 85%
      text-align center
      flex-direction row
      flex-wrap wrap
      .article
        display block
        margin 30px 10px
        border-radius 6px
        box-shadow: 1px 1px 3px #dddddd
        background-color rgba(255, 255, 255, 0.9)
        overflow hidden
        .image-wrapper
          max-height 50%
          overflow hidden
          .image
            width 100%
        &:hover
          box-shadow: 0 0 30px #cacaca
        .content
          margin 25px 20px
          text-align left
          .title
            font-size 23px
            font-weight 600
          .date
            margin 10px 0
          .desc
            color rgba(0, 0, 0, 0.7)
            display -webkit-box
            -webkit-box-orient vertical
            text-overflow ellipsis
            overflow hidden
          .descLineClamp2
            -webkit-line-clamp 2
          .descLineClamp4
            -webkit-line-clamp 4
          .descLineClamp8
            -webkit-line-clamp 8

  .articleLarge
    width 500px
    height 580px

  .articleMiddle
    width 380px
    height 420px

  .articleSmall
    width 320px
    height 380px

  .mainInnerCenter
    justify-content center

  .mainInnerBetween
    justify-content space-between
</style>
